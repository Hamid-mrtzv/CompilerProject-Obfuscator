int main() {
    int _deadVar0 = 1966;
    char _deadVar0_c = 'a';
    if ((_deadVar0 <= 1) && (_deadVar0 * _deadVar0 != 3932)) {
        printf("Confusing unreachable logic %c %d\n", _deadVar0_c, _deadVar0);
        _deadVar0 = _deadVar0 + 1;
    }

    int v0 = 0;
    for (int v1 = 1; v1 <= 10; v1 = v1 + 1) {
        int _confuse1 = 4;
        while (_confuse1 < 9) {
            _confuse1++;
        }

        v0 += v1;
    }
    printf("%d\n", v0);
    return 0;
}
