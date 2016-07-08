# percolate

Using a parser framework like JavaCC or Antlr would make the exercise much simpler.
Each of these frameworks have a custom syntax to define the grammar.
They generate classes for the Entities and parser to parse the input sentence.

In this solution, I have not used any of those frameworks.
The entity classes and parsers have been hand coded.

I have hand coded the Json writer and not used a framework like GSON.

The parser, model classes and Json library have been designed to be extensible.
They however are very specific to the problem in hand.
Example: The Json printer cannot be used to convert arbitary object to Json.

The object model used is similar to what JavaCC would generate for the input grammar -
I have used JavaCC in the past and am speaking from experience.


