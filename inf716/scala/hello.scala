def fib(n: Int): Int =
    if (n < 2) {
        1
    } else {
        fib (n-1) + fib (n-2)
    };


@main
def main(): Unit = 
    println(fib(10));
    println(fibWithAcc(10));

def fibWithAcc(n: Int): Int =
    acc(0, 1, n);

def acc(x1: Int, x2: Int, n: Int): Int =
    if (n == 0) {
        x2
    } else {
        acc(x2, x1 + x2, n-1)
    };



def sum (n: List<Int>): Int =
    match 0 :: n:
        n
