using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordPuzzle
{
    /// <summary>
    /// Utility class responsible for words enum and storing direction of movement inside a dictionary.
    /// </summary>
   public static class Utility
   {
        public static Dictionary<int, string> map = new Dictionary<int, string>();

       /// <summary>
       /// Fill the dictionary with all the possible direction around the world.
       /// </summary>
        public static void FillDirection()
        {
            map.Add(0, "LR");
            map.Add(1, "DOWN");
            map.Add(2, "DDR");
            map.Add(3, "RL");
            map.Add(4, "UP");

            map.Add(5, "DUL");
            map.Add(6, "DDL");
            map.Add(7, "DDR");
        }
    }

    enum WordType : byte
    {
        FullWord,
        PartialWord,
        FullWordAndPartialWord
    }
}
