from time import time
from multiprocessing.pool import Pool

from test import do_some_work


def main():
    ts = time()
    with Pool(4) as p:
        p.map(do_some_work, range(10)) 
    print ("Took: ", time() - ts)


if __name__ == '__main__':
    main()
