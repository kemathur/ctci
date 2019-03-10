"""
Basic util functions for bit manipulation.
"""


"""
get i'th bit of an integer
"""
def get_bit(x, i):
    mask = 1<<i
    y = x & mask
    return (y > 0)


"""
set i'th bit of an integer to 1
"""
def set_bit(x, i):
    mask = 1<<i
    y = x | mask
    return y


"""
clear i'th bit of an integer
clear means setting bit to 0
"""
def clear_bit(x, i):
    mask = ~(1<<i)
    y = x & mask
    return y


"""
update i'th bit of an integer to the given argument.
Argument is 0 or not zero(1)
"""
def update_bit(x, i, v):
    if v !=0 and v != 1:
        raise Exception("v must be 0 or 1")
    mask = ~(1<<i)
    # First clear the bit i
    y = x & mask
    # now set the bit to the appropiate v
    return y | (v<<i)


def main():
    assert (get_bit(2,1) == True)
    assert (get_bit(2,0) == False)
    assert (set_bit(2,1) == 2)
    assert (set_bit(2,0) == 3)
    assert (clear_bit(2,1) == 0)
    assert (clear_bit(2,0) == 2)
    assert (update_bit(2,1,1) == 2)
    assert (update_bit(2,1,0) == 0)


if __name__ == '__main__':
    main()
