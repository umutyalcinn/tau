def concatThree(a: String)(b: String)(c: String): String =
    return a + b + c;

def prefix (a:String): String => String =
    return concatThree(a)(_)("");

def postfix (a:String): String => String =
    return concatThree(_)(a)("");

def preAndPostfix (a:String, b: String): String => String =
    return concatThree(a)(_)(b);

@main
def main(): Unit = 
    var prefixA = prefix("A");
    var postfixA = postfix("B");
    var preAndPostfixAB = preAndPostfix("A", "B");

    println(prefixA("TEST"));
    println(postfixA("TEST"));
    println(preAndPostfixAB("TEST"));







