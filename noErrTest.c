/* A C- program to compute gcd using Euclid’s Algorithm. */
int gcd ( int u, int v )
{
  if ( v == 0 )
  return u ;
  else
  return gcd (v, u-u/v*v) ;
  /* u-u/v*v == u mod v */
}

int input(void)
{
  return 0;
}

void output(int arg)
{

}

void main(void)
{
  int x;
  int y;
  x = input();
  y = input();
  output(gcd(x,y));
}