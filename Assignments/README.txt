Run:
DataCenter.java takes a filename as input argument with values as specified in specification.


Algorithm: ComputeCapacity(N, M, inp[][])
1. Have N HashMap to store N columns. At worst case this takes up O(NM) space. Also we need to examine each value and hence it runs in linear time O(NM)
2. Using HasMap similar Key values are grouped together. ie summation
3. We then take count of version occurring maximum time. This again take O(MN) at worst case
4. Minimum value for each column as returned in step 3 is our capacity. This step takes O(N) time.

overall:
running time : O(MN) - linear on a sequential machine.
space : O(MN) in above case. However it can be run in O(M + N) space as we need not keep all intermediate values.
