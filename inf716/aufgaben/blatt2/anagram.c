#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>

#define MAX_CHAR 28

size_t* countChars(char* word) {
  size_t* charCounts = (size_t*) malloc(MAX_CHAR * sizeof(size_t));
  for (size_t i = 0; i < MAX_CHAR; ++i) {
    charCounts[i] = 0;
  }

  size_t len = strlen(word);
  for (size_t i = 0; i < len; ++i) {
    char currentChar = word[i];
    uint8_t charPos = currentChar % MAX_CHAR;
    charCounts[charPos]++;
  }

  return charCounts;
}

int is_anagram(char* word, char* compared) {
  size_t* wordCharCounts = countChars(word);
  size_t* comparedCharCounts = countChars(compared);

  for (size_t i = 0; i < MAX_CHAR; ++i) {
    if (wordCharCounts[i] != comparedCharCounts[i]) {
      free(wordCharCounts);
      free(comparedCharCounts);
      return 0;
    }
  }

  free(wordCharCounts);
  free(comparedCharCounts);
  return 1;
}


int main() {
    // test your code
  printf("%d\n", is_anagram("mehl", "helm"));
  printf("%d\n", is_anagram("boeing", "airbus"));
  return EXIT_SUCCESS;
}
