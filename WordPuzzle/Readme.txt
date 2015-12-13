************************WORD PUZZLE*************************************************

C# application which search through supplied text file of words. Outputs meaningful words out of
that file that are already stored inside the dictionry.

How Search works?

Program search in all possible direction namely-: 

  ------------|------------
  LR          | Left to right
  RL          | Right to left
  U           | Up
  D           | Down
  DUL         | Diagonal up left
  DUR         | Diagonal up right
  DDL         | Diagonal down left
  DDR         | Diagonal down right

  example-:

  MPI
  LAR
  CKT

  "AR", "AL", "AP", "AK", "AI", "AM", "AC","AT" etc.
  
  Dictionary is used as a data structure for the reason that it has faster lookup time O(1).
  A file can contain any number of words to search from in such a case Dictionary ds fits well.

  Both supplied WordSearch.txt and WordList.txt exists inside /bin.debug folder. For simplicity of the program
  both file's name are hard coded inside the program.



