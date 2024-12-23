def lazyEvaluate(fn: => Int): Int =
    fn;

def foo(a: Int, b: Int): Int =
    a + b;

@main
def main(): Unit =
    lazy val result = lazyEvaluate(foo(10, 5));
    println(result);