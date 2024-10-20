#include <stdio.h>
#include <stdlib.h>

typedef struct smartphone_t {
    char* brand;
    char* model;
    char* color;
    size_t memory;
} smartphone_t;

void print_smartphone_configuration(smartphone_t phone) {
    printf("Your configuration:\n");
    printf("\tBrand: %s:\n", phone.brand);
    printf("\tModel: %s:\n", phone.model);
    printf("\tColor: %s:\n", phone.color);
    printf("Total Memory: %zu\n", phone.memory);
}

void add_additional_sd_card(smartphone_t *phone) {
    phone->memory += 128;
}

int main() {
    smartphone_t phone = {
	.brand = "Sumsang",
	.model = "Milkyway S3",
	.color = "black",
	.memory = 16,
    };
    print_smartphone_configuration(phone);
    add_additional_sd_card(&phone);
    print_smartphone_configuration(phone);
    return 0;
}
