"""
Chapter 05 of Cracking the coding interview
Bit manipulation

"""


"""
Fit y into x from bit i through j. i<j
i to j clearly represents y


eg, 
x = 100000000
y = 101
i = 2
j = 4
z = 100010100

"""
def q1(x, y, i, j):
    # clear i through j in x
    rmask = ((1<<i) - 1)
    lmask = ((~0)<<(j+1))
    mask = lmask | rmask 
    x_m = x & mask
    mask = (y << i)
    z = x_m | mask
    return z


"""
Q3
Flip bit to win.
If we are allowed to flip one 0 to 1,
what is the longest possible subsequence of 1?
"""
def q3(x):
    c_prev = 0
    c_curr = 0
    c_max = 0
    i = 0
    x_c = x
    while abs(x_c) > 0:
        bit = (x & (1<<i)) > 0
        if bit:
            c_prev += 1
            c_curr += 1
        else:
            c_max = max(c_prev, c_max)
            c_prev = c_curr + 1
            c_curr = 0
        i += 1
        x_c >>= 1
    return max(c_max, c_curr, c_prev)


"""
Q4
Print next smallest number and previous largest number,
which has same number of 1s
"""
def q4(x):
    larger = x
    i = 0
    x_c = x
    set = False
    while abs(x_c) > 0:
        bit = x & (1<<i) > 0
        if not set and bit:
            # set this 1 bit as 0. clear bit
            larger = x & (~(1<<i))
            set = True
        elif set and not bit:
            # set this 0 as 1
            larger = larger | (1<<i)
            break
        i += 1
        x_c >>= 1
    return larger


"""
Q6
How many bit swaps needed to go from integer A->B.
eg
i/p:
A = 29 [11101]
B = 15 [01111]

o/p:
2
"""
def q6(a, b):
    # Just count #1s in a^b
    c = a^b
    count = 0
    
    while c!=0:
        x = c&1
        count += x
        c >>= 1

    return count


"""
Q7
swap odd and even bits.
eg
i/p: 001101
o/p: 001110
solution is somewhat non-obvious. we first mask odd bits and move them right.
then take masking of even and move them left.
then take their or.
makes sense but masking odd and even is done using hexadecimal.
"""
def q7(a):
    left = (a & 0xaaaaaaaa) >> 1
    right = (a & 0x55555555) << 1
    return left | right


def main():
    x = int('100000000', 2)
    y = int('101', 2)
    print (x, y)
    print (bin(x), bin(y))
    z = q1(x, y, 2, 4)
    print (z, bin(z))
    assert (z == 276)
    assert (q3(x) == 2)
    assert (q3(y) == 3)
    assert (q4(0) == 0)
    # assert (bin(q4(y)) == '0b110')
    assert q6(x, y) == 3 , "error: " + str(q6(x,y))
    assert q6(29, 15) == 2, "error: " + str(q6(29, 15))
    assert bin(q7(int('001101', 2))) == '0b1110' , "error: " + bin(q7(int('001101', 2)))


if __name__ == '__main__':
    main()


