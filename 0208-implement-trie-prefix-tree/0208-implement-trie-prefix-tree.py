class Trie:

    def __init__(self):
        # Initialize the root of the trie as an empty dictionary
        self.root = {}

    def insert(self, word: str) -> None:
        current = self.root
        for char in word:
            # If the character isn't a child, create a new branch
            if char not in current:
                current[char] = {}
            current = current[char]
        # Mark the end of a valid word
        current['*'] = True

    def search(self, word: str) -> bool:
        current = self.root
        for char in word:
            if char not in current:
                return False
            current = current[char]
        # Return True only if the word marker exists
        return '*' in current

    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for char in prefix:
            if char not in current:
                return False
            current = current[char]
        # If we successfully traversed the prefix, it exists
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)