#include <stdio.h>
int v0(int v1, int v2) {
    int _confuse0 = 7;
    while (_confuse0 < 12) {
        _confuse0++;
    }

    int v3 = v1 - (-v2);
    return v3;
}
int main() {
    int _deadVar1 = 1908;
    char _deadVar1_c = 'b';
    if ((_deadVar1 <= 1) && (_deadVar1 * _deadVar1 != 3816)) {
        printf("Confusing unreachable logic %c %d\n", _deadVar1_c, _deadVar1);
        _deadVar1 = _deadVar1 + 1;
    }

    int v4 = 3;
    int v5 = 4;
    int v6 = v0(v4, v5);
    printf("%d\n", v6);
    return 0;
}
