# Reverse String

Welcome to Reverse String on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

Reversing strings (reading them from right to left, rather than from left to right) is a surprisingly common task in programming.

For example, in bioinformatics, reversing the sequence of DNA or RNA strings is often important for various analyses, such as finding complementary strands or identifying palindromic sequences that have biological significance.

## Instructions

Your task is to reverse a given string.

Some examples:

- Turn `"stressed"` into `"desserts"`.
- Turn `"strops"` into `"sports"`.
- Turn `"racecar"` into `"racecar"`.

## Source

### Created by

- @BNAndras

### Based on

Introductory challenge to reverse an input string - https://medium.freecodecamp.org/how-to-reverse-a-string-in-javascript-in-3-different-ways-75e4763c68cb

# Sum of Multiples

Welcome to Sum of Multiples on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

You work for a company that makes an online, fantasy-survival game.

When a player finishes a level, they are awarded energy points.
The amount of energy awarded depends on which magical items the player found while exploring that level.

## Instructions

Your task is to write the code that calculates the energy points that get awarded to players when they complete a level.

The points awarded depend on two things:

- The level (a number) that the player completed.
- The base value of each magical item collected by the player during that level.

The energy points are awarded according to the following rules:

1. For each magical item, take the base value and find all the multiples of that value that are less than the level number.
2. Combine the sets of numbers.
3. Remove any duplicates.
4. Calculate the sum of all the numbers that are left.

Let's look at an example:

**The player completed level 20 and found two magical items with base values of 3 and 5.**

To calculate the energy points earned by the player, we need to find all the unique multiples of these base values that are less than level 20.

- Multiples of 3 less than 20: `{3, 6, 9, 12, 15, 18}`
- Multiples of 5 less than 20: `{5, 10, 15}`
- Combine the sets and remove duplicates: `{3, 5, 6, 9, 10, 12, 15, 18}`
- Sum the unique multiples: `3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78`
- Therefore, the player earns **78** energy points for completing level 20 and finding the two magical items with base values of 3 and 5.

## Source

### Created by

- @abo64

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg
- @ricemery

### Based on

A variation on Problem 1 at Project Euler - https://projecteuler.net/problem=1

# RNA Transcription

Welcome to RNA Transcription on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

You work for a bioengineering company that specializes in developing therapeutic solutions.

Your team has just been given a new project to develop a targeted therapy for a rare type of cancer.

~~~~exercism/note
It's all very complicated, but the basic idea is that sometimes people's bodies produce too much of a given protein.
That can cause all sorts of havoc.

But if you can create a very specific molecule (called a micro-RNA), it can prevent the protein from being produced.

This technique is called [RNA Interference][rnai].

[rnai]: https://admin.acceleratingscience.com/ask-a-scientist/what-is-rnai/
~~~~

## Instructions

Your task is determine the RNA complement of a given DNA sequence.

Both DNA and RNA strands are a sequence of nucleotides.

The four nucleotides found in DNA are adenine (**A**), cytosine (**C**), guanine (**G**) and thymine (**T**).

The four nucleotides found in RNA are adenine (**A**), cytosine (**C**), guanine (**G**) and uracil (**U**).

Given a DNA strand, its transcribed RNA strand is formed by replacing each nucleotide with its complement:

- `G` -> `C`
- `C` -> `G`
- `T` -> `A`
- `A` -> `U`

~~~~exercism/note
If you want to look at how the inputs and outputs are structured, take a look at the examples in the test suite.
~~~~

## Source

### Created by

- @ricemery

### Contributed to by

- @abo64
- @ErikSchierboom
- @kytrinyx
- @ppartarr
- @rajeshpg

### Based on

Hyperphysics - https://web.archive.org/web/20220408112140/http://hyperphysics.phy-astr.gsu.edu/hbase/Organic/transcription.html

# Accumulate

Welcome to Accumulate on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Implement the `accumulate` operation, which, given a collection and an operation to perform on each element of the collection, returns a new collection containing the result of applying that operation to each element of the input collection.

Given the collection of numbers:

- 1, 2, 3, 4, 5

And the operation:

- square a number (`x => x * x`)

Your code should be able to produce the collection of squares:

- 1, 4, 9, 16, 25

Check out the test suite to see the expected function signature.

## Restrictions

Keep your hands off that collect/map/fmap/whatchamacallit functionality provided by your standard library!
Solve this one yourself using other basic tools instead.

## Source

### Created by

- @ricemery

### Contributed to by

- @ajablonski
- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

Conversation with James Edward Gray II - http://graysoftinc.com/

# Matching Brackets

Welcome to Matching Brackets on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

You're given the opportunity to write software for the Bracketeer™, an ancient but powerful mainframe.
The software that runs on it is written in a proprietary language.
Much of its syntax is familiar, but you notice _lots_ of brackets, braces and parentheses.
Despite the Bracketeer™ being powerful, it lacks flexibility.
If the source code has any unbalanced brackets, braces or parentheses, the Bracketeer™ crashes and must be rebooted.
To avoid such a scenario, you start writing code that can verify that brackets, braces, and parentheses are balanced before attempting to run it on the Bracketeer™.

## Instructions

Given a string containing brackets `[]`, braces `{}`, parentheses `()`, or any combination thereof, verify that any and all pairs are matched and nested correctly.
Any other characters should be ignored.
For example, `"{what is (42)}?"` is balanced and `"[text}"` is not.

## Source

### Created by

- @ricemery

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

Ginna Baker

# Word Count

Welcome to Word Count on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

You teach English as a foreign language to high school students.

You've decided to base your entire curriculum on TV shows.
You need to analyze which words are used, and how often they're repeated.

This will let you choose the simplest shows to start with, and to gradually increase the difficulty as time passes.

## Instructions

Your task is to count how many times each word occurs in a subtitle of a drama.

The subtitles from these dramas use only ASCII characters.

The characters often speak in casual English, using contractions like _they're_ or _it's_.
Though these contractions come from two words (e.g. _we are_), the contraction (_we're_) is considered a single word.

Words can be separated by any form of punctuation (e.g. ":", "!", or "?") or whitespace (e.g. "\t", "\n", or " ").
The only punctuation that does not separate words is the apostrophe in contractions.

Numbers are considered words.
If the subtitles say _It costs 100 dollars._ then _100_ will be its own word.

Words are case insensitive.
For example, the word _you_ occurs three times in the following sentence:

> You come back, you hear me? DO YOU HEAR ME?

The ordering of the word counts in the results doesn't matter.

Here's an example that incorporates several of the elements discussed above:

- simple words
- contractions
- numbers
- case insensitive words
- punctuation (including apostrophes) to separate words
- different forms of whitespace to separate words

`"That's the password: 'PASSWORD 123'!", cried the Special Agent.\nSo I fled.`

The mapping for this subtitle would be:

```text
123: 1
agent: 1
cried: 1
fled: 1
i: 1
password: 2
so: 1
special: 1
that's: 1
the: 2
```

## Source

### Created by

- @sgrif

### Contributed to by

- @ErikSchierboom
- @kytrinyx
- @ppartarr
- @rajeshpg
- @ricemery

### Based on

This is a classic toy problem, but we were reminded of it by seeing it in the Go Tour.

# Anagram

Welcome to Anagram on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

At a garage sale, you find a lovely vintage typewriter at a bargain price!
Excitedly, you rush home, insert a sheet of paper, and start typing away.
However, your excitement wanes when you examine the output: all words are garbled!
For example, it prints "stop" instead of "post" and "least" instead of "stale."
Carefully, you try again, but now it prints "spot" and "slate."
After some experimentation, you find there is a random delay before each letter is printed, which messes up the order.
You now understand why they sold it for so little money!

You realize this quirk allows you to generate anagrams, which are words formed by rearranging the letters of another word.
Pleased with your finding, you spend the rest of the day generating hundreds of anagrams.

## Instructions

Your task is to, given a target word and a set of candidate words, to find the subset of the candidates that are anagrams of the target.

An anagram is a rearrangement of letters to form a new word: for example `"owns"` is an anagram of `"snow"`.
A word is _not_ its own anagram: for example, `"stop"` is not an anagram of `"stop"`.

The target and candidates are words of one or more ASCII alphabetic characters (`A`-`Z` and `a`-`z`).
Lowercase and uppercase characters are equivalent: for example, `"PoTS"` is an anagram of `"sTOp"`, but `StoP` is not an anagram of `sTOp`.
The anagram set is the subset of the candidate set that are anagrams of the target (in any order).
Words in the anagram set should have the same letter case as in the candidate set.

Given the target `"stone"` and candidates `"stone"`, `"tones"`, `"banana"`, `"tons"`, `"notes"`, `"Seton"`, the anagram set is `"tones"`, `"notes"`, `"Seton"`.

You must return the anagrams in the same order as they are listed in the candidate words.

## Source

### Created by

- @sgrif

### Contributed to by

- @ErikSchierboom
- @kytrinyx
- @ppartarr
- @rajeshpg
- @ricemery

### Based on

Inspired by the Extreme Startup game - https://github.com/rchatley/extreme_startup

# Series

Welcome to Series on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Given a string of digits, output all the contiguous substrings of length `n` in that string in the order that they appear.

For example, the string "49142" has the following 3-digit series:

- "491"
- "914"
- "142"

And the following 4-digit series:

- "4914"
- "9142"

And if you ask for a 6-digit series from a 5-digit string, you deserve whatever you get.

Note that these series are only required to occupy _adjacent positions_ in the input;
the digits need not be _numerically consecutive_.

## Source

### Created by

- @ricemery

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

A subset of the Problem 8 at Project Euler - https://projecteuler.net/problem=8

# Luhn

Welcome to Luhn on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Given a number determine whether or not it is valid per the Luhn formula.

The [Luhn algorithm][luhn] is a simple checksum formula used to validate a variety of identification numbers, such as credit card numbers and Canadian Social Insurance Numbers.

The task is to check if a given string is valid.

## Validating a Number

Strings of length 1 or less are not valid.
Spaces are allowed in the input, but they should be stripped before checking.
All other non-digit characters are disallowed.

### Example 1: valid credit card number

```text
4539 3195 0343 6467
```

The first step of the Luhn algorithm is to double every second digit, starting from the right.
We will be doubling

```text
4539 3195 0343 6467
↑ ↑  ↑ ↑  ↑ ↑  ↑ ↑  (double these)
```

If doubling the number results in a number greater than 9 then subtract 9 from the product.
The results of our doubling:

```text
8569 6195 0383 3437
```

Then sum all of the digits:

```text
8+5+6+9+6+1+9+5+0+3+8+3+3+4+3+7 = 80
```

If the sum is evenly divisible by 10, then the number is valid.
This number is valid!

### Example 2: invalid credit card number

```text
8273 1232 7352 0569
```

Double the second digits, starting from the right

```text
7253 2262 5312 0539
```

Sum the digits

```text
7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57
```

57 is not evenly divisible by 10, so this number is not valid.

[luhn]: https://en.wikipedia.org/wiki/Luhn_algorithm

## Source

### Created by

- @ricemery

### Contributed to by

- @abo64
- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

The Luhn Algorithm on Wikipedia - https://en.wikipedia.org/wiki/Luhn_algorithm

# Run-Length Encoding

Welcome to Run-Length Encoding on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Implement run-length encoding and decoding.

Run-length encoding (RLE) is a simple form of data compression, where runs (consecutive data elements) are replaced by just one data value and count.

For example we can represent the original 53 characters with only 13.

```text
"WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"  ->  "12WB12W3B24WB"
```

RLE allows the original data to be perfectly reconstructed from the compressed data, which makes it a lossless data compression.

```text
"AABCCCDEEEE"  ->  "2AB3CD4E"  ->  "AABCCCDEEEE"
```

For simplicity, you can assume that the unencoded string will only contain the letters A through Z (either lower or upper case) and whitespace.
This way data to be encoded will never contain any numbers and numbers inside data to be decoded always represent the count for the following character.

## Source

### Created by

- @abo64

### Contributed to by

- @ppartarr
- @rajeshpg
- @ricemery

### Based on

Wikipedia - https://en.wikipedia.org/wiki/Run-length_encoding

# Matrix

Welcome to Matrix on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Given a string representing a matrix of numbers, return the rows and columns of that matrix.

So given a string with embedded newlines like:

```text
9 8 7
5 3 2
6 6 7
```

representing this matrix:

```text
    1  2  3
  |---------
1 | 9  8  7
2 | 5  3  2
3 | 6  6  7
```

your code should be able to spit out:

- A list of the rows, reading each row left-to-right while moving top-to-bottom across the rows,
- A list of the columns, reading each column top-to-bottom while moving from left-to-right.

The rows for our example matrix:

- 9, 8, 7
- 5, 3, 2
- 6, 6, 7

And its columns:

- 9, 5, 6
- 8, 3, 6
- 7, 2, 7

## Source

### Created by

- @ricemery

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

Exercise by the JumpstartLab team for students at The Turing School of Software and Design. - https://turing.edu

# Pig Latin

Welcome to Pig Latin on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

Your parents have challenged you and your sibling to a game of two-on-two basketball.
Confident they'll win, they let you score the first couple of points, but then start taking over the game.
Needing a little boost, you start speaking in [Pig Latin][pig-latin], which is a made-up children's language that's difficult for non-children to understand.
This will give you the edge to prevail over your parents!

[pig-latin]: https://en.wikipedia.org/wiki/Pig_latin

## Instructions

Your task is to translate text from English to Pig Latin.
The translation is defined using four rules, which look at the pattern of vowels and consonants at the beginning of a word.
These rules look at each word's use of vowels and consonants:

- vowels: the letters `a`, `e`, `i`, `o`, and `u`
- consonants: the other 21 letters of the English alphabet

## Rule 1

If a word begins with a vowel, or starts with `"xr"` or `"yt"`, add an `"ay"` sound to the end of the word.

For example:

- `"apple"` -> `"appleay"` (starts with vowel)
- `"xray"` -> `"xrayay"` (starts with `"xr"`)
- `"yttria"` -> `"yttriaay"` (starts with `"yt"`)

## Rule 2

If a word begins with one or more consonants, first move those consonants to the end of the word and then add an `"ay"` sound to the end of the word.

For example:

- `"pig"` -> `"igp"` -> `"igpay"` (starts with single consonant)
- `"chair"` -> `"airch"` -> `"airchay"` (starts with multiple consonants)
- `"thrush"` -> `"ushthr"` -> `"ushthray"` (starts with multiple consonants)

## Rule 3

If a word starts with zero or more consonants followed by `"qu"`, first move those consonants (if any) and the `"qu"` part to the end of the word, and then add an `"ay"` sound to the end of the word.

For example:

- `"quick"` -> `"ickqu"` -> `"ickquay"` (starts with `"qu"`, no preceding consonants)
- `"square"` -> `"aresqu"` -> `"aresquay"` (starts with one consonant followed by `"qu`")

## Rule 4

If a word starts with one or more consonants followed by `"y"`, first move the consonants preceding the `"y"`to the end of the word, and then add an `"ay"` sound to the end of the word.

Some examples:

- `"my"` -> `"ym"` -> `"ymay"` (starts with single consonant followed by `"y"`)
- `"rhythm"` -> `"ythmrh"` -> `"ythmrhay"` (starts with multiple consonants followed by `"y"`)

## Source

### Created by

- @ricemery

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

The Pig Latin exercise at Test First Teaching by Ultrasaurus - https://github.com/ultrasaurus/test-first-teaching/blob/master/learn_ruby/pig_latin/

# Alphametics

Welcome to Alphametics on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Given an alphametics puzzle, find the correct solution.

[Alphametics][alphametics] is a puzzle where letters in words are replaced with numbers.

For example `SEND + MORE = MONEY`:

```text
  S E N D
  M O R E +
-----------
M O N E Y
```

Replacing these with valid numbers gives:

```text
  9 5 6 7
  1 0 8 5 +
-----------
1 0 6 5 2
```

This is correct because every letter is replaced by a different number and the words, translated into numbers, then make a valid sum.

Each letter must represent a different digit, and the leading digit of a multi-digit number must not be zero.

[alphametics]: https://en.wikipedia.org/wiki/Alphametics

## Source

### Created by

- @abo64

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg
- @ricemery

# Variable Length Quantity

Welcome to Variable Length Quantity on Exercism's Scala Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Implement variable length quantity encoding and decoding.

The goal of this exercise is to implement [VLQ][vlq] encoding/decoding.

In short, the goal of this encoding is to encode integer values in a way that would save bytes.
Only the first 7 bits of each byte are significant (right-justified; sort of like an ASCII byte).
So, if you have a 32-bit value, you have to unpack it into a series of 7-bit bytes.
Of course, you will have a variable number of bytes depending upon your integer.
To indicate which is the last byte of the series, you leave bit #7 clear.
In all of the preceding bytes, you set bit #7.

So, if an integer is between `0-127`, it can be represented as one byte.
Although VLQ can deal with numbers of arbitrary sizes, for this exercise we will restrict ourselves to only numbers that fit in a 32-bit unsigned integer.
Here are examples of integers as 32-bit values, and the variable length quantities that they translate to:

```text
 NUMBER        VARIABLE QUANTITY
00000000              00
00000040              40
0000007F              7F
00000080             81 00
00002000             C0 00
00003FFF             FF 7F
00004000           81 80 00
00100000           C0 80 00
001FFFFF           FF FF 7F
00200000          81 80 80 00
08000000          C0 80 80 00
0FFFFFFF          FF FF FF 7F
```

[vlq]: https://en.wikipedia.org/wiki/Variable-length_quantity

Remember that in Scala there are two forms of the right shift operator. The `>>` operator preserves the sign, while `>>>` zeroes the leftmost bits.

## Source

### Created by

- @ricemery

### Contributed to by

- @ErikSchierboom
- @ppartarr
- @rajeshpg

### Based on

A poor Splice developer having to implement MIDI encoding/decoding. - https://splice.com