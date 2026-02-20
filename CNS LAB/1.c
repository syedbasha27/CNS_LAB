#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	char str[] = "Hello World";
	int i, len;

	len = strlen(str);
	char str1[12];

	for (i = 0; i < len; i++)
	{
		str1[i] = str[i] ^ 0;
		printf("%c", str1[i]);
	}

	str1[len] = '\0';
	printf("\n");

	return 0;
}