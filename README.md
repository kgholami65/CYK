# CYK
CYK is a parsing algorithm for context-free grammars.
you can use this software which is programmed in java, to check whether a set of grammar rules can create a specific string or not.
input example:
S->AB|BC
A->BA|a
B->CC|b
C->AB|a
exit   #continues to get grammar rules until user enters 'exit'.
baaba #inputs string
note that the first variable is your start grammar rule
the grammar must be in chamsky form.
