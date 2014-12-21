SRCS = queueTest.java Queue.java

JFLAGS = -g -Xlint:unchecked

CLASSES = $(SRCS:.java=.class)

.PHONY: clean default style 

default: $(CLASSES)

$(CLASSES): $(SRCS) 
	javac $(JFLAGS) $(SRCS)

check: queueTest.class
	java queueTest 

# Remove files that are unnecessary or that can be regenerated with make.
clean :
	$(RM) *~ *.class
