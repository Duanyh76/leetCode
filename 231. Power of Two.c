bool isPowerOfTwo(int n) 
{
	if (n == 1)
		return true;
	if (n % 2 == 1 || n <= 0)
		return false;
	return isPowerOfTwo(n / 2);
}

bool isPowerOfTwo(int n)
{
	if (n <= 0)
		return false;
	int count = 0;
	while (n != 0)
	{
		count += n & 1;
		n >>= 1;
	}
	return count == 1;
}
