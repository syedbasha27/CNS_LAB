#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char str[] = "Hello World";
    char str1[12];
    char str2[12];
    char str3[12];

    int i, len;

    strcpy(str2, str);

    len = strlen(str);

    for(i = 0; i < len; i++)
    {
        str1[i] = str[i] & 127;
        printf("%c", str1[i]);
    }
    str1[i] = '\0';

    printf("\n");

    for(i = 0; i < len; i++)
    {
        str3[i] = str2[i] ^ 127;
        printf("%c", str3[i]);
    }
    str3[i] = '\0';

    printf("\n");

    return 0;
}