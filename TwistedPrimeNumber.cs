using System;
class TwistedPrimeNumber
{
    public static void Main ()
    {
        Console.Write ("Enter a number: ");
        int num = Convert.ToInt32 (Console.ReadLine ());

        //Calclating Reverse of Number
        int revNo = ReverseNo(num);

        //Condition check for both the number (Entered number and Reversed No) 
        //if both are prime then it is twisted prime number.
        if (IsPrime (num) && IsPrime (revNo))
            Console.WriteLine (num + " is twisted Prime No.");
        else
            Console.WriteLine (num + " is not a twisted Prime No.");
        Console.ReadLine ();
    }

    //Method to calculate reverse of number
    public static int ReverseNo(int num)
    {
        int revNo = 0;
        while (num > 0)
        {
         revNo = revNo * 10 + num % 10;
         num = num / 10;
        }
        return revNo;
    }

    //Method to check for prime number
    public static bool IsPrime(int num)
    {
        bool isPrime = true;
        for (int i = 2; i < num / 2; i++)
        {
         if (num % i == 0)
         {
             isPrime = false;
             break;
         }
        }
        return isPrime;
    }
}
