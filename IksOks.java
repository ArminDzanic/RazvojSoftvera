import java.util.Scanner;

public class IksOks
{
  public static void main(String[] args)
  {
    int[][] Board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    Scanner scanner = new Scanner(System.in);
    int CurrentPlayer = 1;
    PrintBoard(Board);

    while(true)
    {
      if(CheckForGameOver(Board))
      {
        System.out.println("Board is full. Game over. Tie");
        break;
      }
      System.out.print("Player " + CurrentPlayer + " enter a cell number.");
      int cell = scanner.nextInt();
      if(cell < 1 || cell > 9)
      {
        System.out.println("You picked the wrong number fool!");
        continue;
      }
      int row = (cell - 1) / 3;
      int col = (cell - 1) % 3;
      if(Board[row][col] != 0)
      {
        System.out.println("Cell already occupied!");
        continue;
      }
      Board[row][col] = CurrentPlayer;
      if(CheckForWin(Board, CurrentPlayer))
      {
        System.out.println("Player " + CurrentPlayer + " has won!");
        PrintBoard(Board);
        break;
      }
      PrintBoard(Board);
      if(CurrentPlayer == 1)
      {
        CurrentPlayer = 2;
      }
      else
      {
        CurrentPlayer = 1;
      }
    }
  }

  public static void PrintBoard(int[][] Board)
  {
    for(int i = 0; i < 3; ++i)
    {
      for(int j = 0; j < 3; ++j)
      {
        System.out.print(Board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean CheckForWin(int[][] Board, int CurrentPlayer)
  {
    // Prvi red
    if(Board[0][0] == CurrentPlayer && Board[0][1] == CurrentPlayer && Board[0][2] == CurrentPlayer)
    {
      return true;
    }
    // Drugi red
    if(Board[1][0] == CurrentPlayer && Board[1][1] == CurrentPlayer && Board[1][2] == CurrentPlayer)
    {
      return true;
    }
    // Treci red
    if(Board[2][0] == CurrentPlayer && Board[2][1] == CurrentPlayer && Board[2][2] == CurrentPlayer)
    {
      return true;
    }
    // Prva kolona
    if(Board[0][0] == CurrentPlayer && Board[1][0] == CurrentPlayer && Board[2][0] == CurrentPlayer)
    {
      return true;
    }
    // Druga kolona
    if(Board[0][1] == CurrentPlayer && Board[1][1] == CurrentPlayer && Board[2][1] == CurrentPlayer)
    {
      return true;
    }
    // Treca kolona
    if(Board[0][2] == CurrentPlayer && Board[1][2] == CurrentPlayer && Board[2][2] == CurrentPlayer)
    {
      return true;
    }
    // Glavna dijagonala
    if(Board[0][0] == CurrentPlayer && Board[1][1] == CurrentPlayer && Board[2][2] == CurrentPlayer)
    {
      return true;
    }
    // Sporedna dijagonala
    if(Board[0][2] == CurrentPlayer && Board[1][1] == CurrentPlayer && Board[2][0] == CurrentPlayer)
    {
      return true;
    }
    return false;
  }

  public static boolean CheckForGameOver(int[][] Board)
  {
    for(int i = 0; i < 3; ++i)
    {
      for(int j = 0; j < 3; ++j)
      {
        if(Board[i][j] == 0)
        {
          return false;
        }
      }
    }
    return true;
  }
}
