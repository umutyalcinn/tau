#include <stdio.h>
#include <math.h>

int is_prime(int num) {
    if (num < 2) {
	return -1;
    }

    for(int i = 2; i < num; ++i) {
	if(num % i == 0) {
	    return -1;
	}
    }

    return 0;
}

int calculate_nth_prime_number(int n) {
    if (n < 1) {
	return -1;
    }

    int i = 0;
    int num = 2;

    while (i < n) {
	if(is_prime(num) == 0) {
	    printf("Found prime: %d\n", num);
	    ++i;
	}

	++num;
    }

    return num - 1;
}

int main() {
    printf("%d", calculate_nth_prime_number(100));
}
