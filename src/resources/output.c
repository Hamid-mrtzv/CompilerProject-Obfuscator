#include <stdio.h>
int v0(int v1, int v2) {
    int _deadVar0 = 1030;
    char _deadVar0_c = 'a';
    if ((_deadVar0 <= 1) && (_deadVar0 * _deadVar0 != 2060)) {
        printf("Confusing unreachable logic %c %d\n", _deadVar0_c, _deadVar0);
        _deadVar0 = _deadVar0 + 1;
    }

    int v3 = v1 - (-v2);
    return v3;
}
int main() {
    int _deadVar1 = 1179;
    char _deadVar1_c = 'b';
    if ((_deadVar1 <= 1) && (_deadVar1 * _deadVar1 != 2358)) {
        printf("Confusing unreachable logic %c %d\n", _deadVar1_c, _deadVar1);
        _deadVar1 = _deadVar1 + 1;
    }

    int v4 = 3;
    int v5 = 4;
    int v6 = v0(v4, v5);
    printf("%d\n", v6);
    return 0;
}
