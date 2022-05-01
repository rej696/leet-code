
int slow_divide(int dividend, int divisor){
  uint32_t quotient = 0;
  uint32_t dividend_sign = ((dividend >> 31) & 0b1);
  uint32_t divisor_sign = ((divisor >> 31) & 0b1);
  uint32_t result_sign = (dividend_sign ^ divisor_sign);
  uint32_t u_divisor = (uint32_t) (divisor_sign ? -((long) divisor) : divisor);
  uint32_t u_dividend = (uint32_t) (dividend_sign ? -((long) dividend) : dividend);
  
  while (u_dividend >= u_divisor)
  {
    u_dividend -= u_divisor;
    if (quotient == INT_MAX)
    {
      quotient = (result_sign ? quotient + 1 : quotient);
      break;
    }
    ++quotient;
  } 
  return (dividend_sign ^ divisor_sign) ? -quotient : quotient;
}

int divide(int dividend, int divisor)
{
  if(divisor == 0 || (dividend == INT_MIN && divisor == -1))
    return INT_MAX;
  
  long quotient = 0;
  
  uint32_t dividend_sign = ((dividend >> 31) & 0b1);
  uint32_t divisor_sign = ((divisor >> 31) & 0b1);
  uint32_t result_sign = (dividend_sign ^ divisor_sign);
  unsigned int u_divisor = (uint32_t) (divisor_sign ? -((long) divisor) : divisor);
  unsigned int u_dividend = (uint32_t) (dividend_sign ? -((long) dividend) : dividend);
    
  for (int i = 31; i >= 0; i--)
  {
    if ((u_dividend >> i) >= u_divisor)
    {
      u_dividend -= (u_divisor << i);
      quotient = (quotient << 1) | 1u; 
    }
    else
    {
      quotient <<= 1;
    }
  }
  
  return result_sign ? -quotient : quotient;
}