#include <stdio.h>

void printn(char c, int n) {
    for(int i = 0; i < n; ++i) {
	printf("%c", c);
    }
}

void print_tree_char(int height, char sym) {
    for(int i = 0; i < height; ++i) {
	printn(' ', height - 1 - i);
	printn(sym, 2*i + 1);
	printf("\n");
    }

    printn(' ', height - 1);
    printn(sym, 1);
    printf("\n");
}

void print_tree(int height) {
    print_tree_char(height, '*');
}


int main() {
    print_tree(10);
    print_tree_char(20, 'o');
}
