run:Main.class
	java PlayfairCipher $(A) $(B)

Main.class: PlayfairCipher.java
	javac PlayfairCipher.java

clean: 
	rm PlayfairCipher.class