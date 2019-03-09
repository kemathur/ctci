from time import time
from test import do_some_work

def main():
    ts = time()
    for i in range(10):
        do_some_work(i)
    print ("Took: ", time() - ts)


if __name__ == '__main__':
    main()
