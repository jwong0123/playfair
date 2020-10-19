run:Main.class
	java PlayfairCipher $(ARGS)

Main.class: PlayfairCipher.java
	javac PlayfairCipher.java

clean: 
	rm PlayfairCipher.class
