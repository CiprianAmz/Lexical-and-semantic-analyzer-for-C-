/* A C- program to compute gcd using Euclid’s Algorithm. */
int test;

int gcd (int u, int v) {
  if ( v == 0 )
    return u ;
  else
    return gcd (v, u-u/v*v) ;
/* u-u/v*v == u mod v */
}

void gcd(void) {

}

void main(void) {
  int x;
  int y[4];

  {
    int x;
    int w;
  }

  x = main;
  x = 1 + kapa + 2 + 3 + 4;
  x = gcd();
  y = input();

  return main();
  /* output(gcd(x,y));*/
}