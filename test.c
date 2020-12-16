/* A C- program to compute gcd using Euclid’s Algorithm. */
int test;

int gcd ( int u, int v ) {
  if ( v == 0 )
    return u ;
  else
    return gcd (v, u-u/v*v) ;
/* u-u/v*v == u mod v */
}

void main(void) {
  int x;
  int y;

  x = 1 + 2 + 3 + 4;
  x = input();
  y = input();
  output(gcd(x,y));
}