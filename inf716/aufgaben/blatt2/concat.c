#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>

char* concat(char* string1, char* string2) {

  size_t aLen = strlen(string1);
  size_t bLen = strlen(string2);

  size_t newLen = aLen + bLen; //we allocate one more for '\0'
  char* newString = (char*)malloc(newLen * sizeof(char));

  for (size_t i = 0; i < aLen; ++i) {
    newString[i] = string1[i];
  }

  for (size_t i = 0; i < bLen; ++i) {
    newString[i + aLen] = string2[i];
  }

  newString[newLen] = '\0';
  return newString;
}

int main() {
   // test your code here
   return EXIT_SUCCESS;
}
