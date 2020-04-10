# MO-s-Algorithm
Algorithm to solve offline range query

It uses concept of Sqrt decomposition but in little advance way.

In sqrt decomposition the answer of each block is stored in array of block.

But in MO's algorithm the queries are sorted according to block size & answer of previous query is used to find answer for next query.

Here no block array is used as like Sqrt Decomposition.

Complexity :

            Time Complexity : 0((N+Q)*sqrt(N))
            Space Complexity: 0(N*Q)
