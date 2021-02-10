Use StringBuffer when doing mutiple times string concatenation:
because String is immutable in Java, everytime we change a Sting(e.g. doing
concatenation:) we create a new String in the memory!