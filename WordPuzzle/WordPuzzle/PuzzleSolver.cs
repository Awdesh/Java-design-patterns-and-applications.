using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace WordPuzzle
{
    /// <summary>
    /// Puzzle Solver class responsible for storing words in a dictionary
    /// and then search characters in all possible direction around the word in a two dimesional array
    /// and match if it exists inside the dictionary.
    /// </summary>
    static class PuzzleSolver
    {
        // Using OrdinalIgnoreCase in order to search all words. Dictionary has been used to store and search words from
        // since dictionary has fatest retrieval time i.e. O(1) constant time.
        static Dictionary<string, WordType> WordsMap = new Dictionary<string, WordType>(10000, StringComparer.OrdinalIgnoreCase);
        const int _minLength = 3; // Minimum length of matching words.

        /// <summary>
        /// Method responsible for calling methods to store data inside dictionary and search words from it.
        /// </summary>
        public static void Solve()
        {
            StoreData();
            SearchWord();
            Console.ReadLine();
        }

        /// <summary>
        /// Stores the data inside the dictionary 
        /// </summary>
        private static void StoreData()
        {
            // Read in dictionary.
            using (StreamReader reader = new StreamReader("WordList.txt"))
            {
                while (true)
                {
                    string line = reader.ReadLine();
                    if (line == null)
                    {
                        break;
                    }
                    if (line.Length >= _minLength)
                    {
                        for (int i = 1; i <= line.Length; i++)
                        {
                            string substring = line.Substring(0, i);
                            WordType value;
                            // TryGetValue is safer method as it wraps up retrieval inside a try catch block.
                            if (WordsMap.TryGetValue(substring, out value))
                            {
                                if (i == line.Length)
                                {
                                    // If only partial word is stored.
                                    if (value == WordType.PartialWord)
                                    {
                                        // Upgrade type.
                                        WordsMap[substring] = WordType.FullWordAndPartialWord;
                                    }
                                }
                                else
                                {
                                    // If not a full word and only partial word is stored.
                                    if (value == WordType.FullWord)
                                    {
                                        WordsMap[substring] = WordType.FullWordAndPartialWord;
                                    }
                                }
                            }
                            else
                            {
                                // If this is a full word.
                                if (i == line.Length)
                                {
                                    WordsMap.Add(substring, WordType.FullWord);
                                }
                                else
                                {
                                    WordsMap.Add(substring, WordType.PartialWord);
                                }
                            }
                        }
                    }
                }
            }
        }

        /// <summary>
        /// Open the "WordSearch.txt" file and create a 2D array with all the letters of the words.
        /// Further call the search method which searches different characters in all different direction.
        /// </summary>
        private static void SearchWord()
        {
            string[] lines = File.ReadAllLines("WordSearch.txt");
            Utility.FillDirection();

            if (lines.Length <= 0)
            {
                return;
            }
            
            int x = lines[0].Length;
            int y = lines.Length;

            char[,] array = new char[x, y];
            for (int i = 0; i < x; i++)
            {
                for (int a = 0; a < y; a++)
                {
                    // Fill in the 2-D array with the words from "WordSearch" file,
                    // each index of 2-D array will contain single character.
                    array[a, i] = lines[a][i];
                }
            }
            // Start at each square in the 2D array.
            // Traverse towards x direction (horizaontially, starting from the top element[0,0]).
            for (int i = 0; i < x; i++)
            {
                // Traverse towards y direction (vertically down, starting from the top element[0,0]).
                for (int j = 0; j < y; j++)
                {
                    // Search all 8 directions as specified below.
                    //  Designation | Description
                    //  ------------|------------
                    //  LR          | Left to right
                    //  RL          | Right to left
                    //  U           | Up
                    //  D           | Down
                    //  DUL         | Diagonal up left
                    //  DUR         | Diagonal up right
                    //  DDL         | Diagonal down left
                    //  DDR         | Diagonal down right
                    for (int direction = 0; direction < 8; direction++)
                    {
                        SearchInDirection(array, i, j, x, y, "", direction);
                    }
                }
            }
        }

        /// <summary>
        /// Search for the letter in all the directions around the given index of the character.
        /// </summary>
        /// <param name="array">2-D array containing all the words.</param>
        /// <param name="i">x- index of the 2-D array.</param>
        /// <param name="a">y- index of the 2-D array.</param>
        /// <param name="width">length of the word being traversed.</param>
        /// <param name="height">total number of words separated by new line.</param>
        /// <param name="build">string that gets built in all 8 direction.</param>
        /// <param name="direction">specify the direction to get a new word.</param>
        private static void SearchInDirection(char[,] array, int i, int j, int width, int height, string build, int direction)
        {
            // map to store the words that are found.
            Dictionary<string, bool> foundWordsMap= new Dictionary<string, bool>(StringComparer.OrdinalIgnoreCase);
            
            // check for invalid index, out of bound index.
            if (i >= width || i < 0 || j >= height || j < 0)
            {
                return;
            }
            
            char letter = array[j, i];
            // Append.
            string res = build + letter;
            WordType value;
            if (WordsMap.TryGetValue(res, out value))
            {
                // Handle all full words.
                if (value == WordType.FullWord || value == WordType.FullWordAndPartialWord)
                {
                    // Don't display same word twice.
                    if (!foundWordsMap.ContainsKey(res))
                    {
                        string val = String.Empty;
                        if (Utility.map.ContainsKey(direction))
                        {
                            Utility.map.TryGetValue(direction, out val);
                        }

                        Console.WriteLine("{0} found at {1},{2} in direction {3}", res, i + 1, j, val);
                        foundWordsMap.Add(res, true);
                    }
                }
                
                // If word is partial then look into map that contains partial words.
                if (value == WordType.PartialWord || value == WordType.FullWordAndPartialWord)
                {
                    // Continue in one direction.
                    switch (direction)
                    {
                        // LR -: Left to Right.
                        case 0:
                            SearchInDirection(array, i + 1, j, width, height, res, direction);
                            break;
                        // Down
                        case 1:
                            SearchInDirection(array, i, j + 1, width, height, res, direction);
                            break;
                        // DDR -: Diagonal down right
                        case 2:
                            SearchInDirection(array, i + 1, j + 1, width, height, res, direction);
                            break;
                        // RL -: Right to Left.
                        case 3:
                            SearchInDirection(array, i - 1, j, width, height, res, direction);
                            break;
                        // Up
                        case 4:
                            SearchInDirection(array, i, j - 1, width, height, res, direction);
                            break;
                        // DUL -: Diagonal up left
                        case 5:
                            SearchInDirection(array, i - 1, j - 1, width, height, res, direction);
                            break;
                        // DDL -: Diagonal down left
                        case 6:
                            SearchInDirection(array, i - 1, j + 1, width, height, res, direction);
                            break;
                        // DDR -: Diagonal up right
                        case 7:
                            SearchInDirection(array, i + 1, j - 1, width, height, res, direction);
                            break;
                    }
                }
            }
        }
    }
}
