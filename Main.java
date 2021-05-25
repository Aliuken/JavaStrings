1. STRING_COMPARATOR

STRING_COMPARATOR.compare(null, null) <=> 0
STRING_COMPARATOR.compare(null, "bbb") <=> -1
STRING_COMPARATOR.compare("aaa", null) <=> 1
STRING_COMPARATOR.compare("aaa", "aba") <=> -1
STRING_COMPARATOR.compare("aba", "aaa") <=> 1
STRING_COMPARATOR.compare("aaa", "aaa") <=> 0
STRING_COMPARATOR.compare("aaa", "aAa") <=> 32
STRING_COMPARATOR.compare("aAa", "aaa") <=> -32


2. STRING_COMPARATOR_IGNORE_CASE

STRING_COMPARATOR_IGNORE_CASE.compare(null, null) <=> 0
STRING_COMPARATOR_IGNORE_CASE.compare(null, "bbb") <=> -1
STRING_COMPARATOR_IGNORE_CASE.compare("aaa", null) <=> 1
STRING_COMPARATOR_IGNORE_CASE.compare("aaa", "aba") <=> -1
STRING_COMPARATOR_IGNORE_CASE.compare("aba", "aaa") <=> 1
STRING_COMPARATOR_IGNORE_CASE.compare("aaa", "aaa") <=> 0
STRING_COMPARATOR_IGNORE_CASE.compare("aaa", "aAa") <=> 0
STRING_COMPARATOR_IGNORE_CASE.compare("aAa", "aaa") <=> 0


3. equalsIgnoreCase

equalsIgnoreCase(null, null) <=> true
equalsIgnoreCase(null, "bbb") <=> false
equalsIgnoreCase("aaa", null) <=> false
equalsIgnoreCase("aaa", "aba") <=> false
equalsIgnoreCase("aba", "aaa") <=> false
equalsIgnoreCase("aaa", "aaa") <=> true
equalsIgnoreCase("aaa", "aAa") <=> true
equalsIgnoreCase("aAa", "aaa") <=> true


4. strip

strip(null) <=> null
strip(" aaa ") <=> "aaa"


5. isNullOrEmpty

isNullOrEmpty(null) <=> true
isNullOrEmpty("") <=> true
isNullOrEmpty("   ") <=> false
isNullOrEmpty(" aaa ") <=> false


6. isNullOrWhitespace

isNullOrWhitespace(null) <=> true
isNullOrWhitespace("") <=> true
isNullOrWhitespace("   ") <=> true
isNullOrWhitespace(" aaa ") <=> false


7. nonNullNorEmpty

nonNullNorEmpty(null) <=> false
nonNullNorEmpty("") <=> false
nonNullNorEmpty("   ") <=> true
nonNullNorEmpty(" aaa ") <=> true


8. nonNullNorWhitespace

nonNullNorWhitespace(null) <=> false
nonNullNorWhitespace("") <=> false
nonNullNorWhitespace("   ") <=> false
nonNullNorWhitespace(" aaa ") <=> true


9. requireNonNullNorEmpty

requireNonNullNorEmpty(null) <=> java.lang.NullPointerException null
requireNonNullNorEmpty("") <=> java.lang.IllegalArgumentException null
requireNonNullNorEmpty("   ") <=> "   "
requireNonNullNorEmpty(" aaa ") <=> " aaa "


10. requireNonNullNorWhitespace

requireNonNullNorWhitespace(null) <=> java.lang.NullPointerException null
requireNonNullNorWhitespace("") <=> java.lang.IllegalArgumentException null
requireNonNullNorWhitespace("   ") <=> java.lang.IllegalArgumentException null
requireNonNullNorWhitespace(" aaa ") <=> "aaa"


11. requireNonNullNorEmptyWithMessage

requireNonNullNorEmpty(null, "Null or empty not allowed") <=> java.lang.NullPointerException Null or empty not allowed
requireNonNullNorEmpty("", "Null or empty not allowed") <=> java.lang.IllegalArgumentException Null or empty not allowed
requireNonNullNorEmpty("   ", "Null or empty not allowed") <=> "   "
requireNonNullNorEmpty(" aaa ", "Null or empty not allowed") <=> " aaa "


12. requireNonNullNorWhitespaceWithMessage

requireNonNullNorWhitespace(null, "Null or whitespace not allowed") <=> java.lang.NullPointerException Null or whitespace not allowed
requireNonNullNorWhitespace("", "Null or whitespace not allowed") <=> java.lang.IllegalArgumentException Null or whitespace not allowed
requireNonNullNorWhitespace("   ", "Null or whitespace not allowed") <=> java.lang.IllegalArgumentException Null or whitespace not allowed
requireNonNullNorWhitespace(" aaa ", "Null or whitespace not allowed") <=> "aaa"


13. requireNonNullNorEmptyWithMessageSupplier

requireNonNullNorEmpty(null, null) <=> java.lang.NullPointerException null
requireNonNullNorEmpty("", null) <=> java.lang.IllegalArgumentException null
requireNonNullNorEmpty("   ", null) <=> "   "
requireNonNullNorEmpty(" aaa ", null) <=> " aaa "

requireNonNullNorEmpty(null, this::nonNullNorEmptyMessageSupplier) <=> java.lang.NullPointerException Supplier: Null or empty not allowed
requireNonNullNorEmpty("", this::nonNullNorEmptyMessageSupplier) <=> java.lang.IllegalArgumentException Supplier: Null or empty not allowed
requireNonNullNorEmpty("   ", this::nonNullNorEmptyMessageSupplier) <=> "   "
requireNonNullNorEmpty(" aaa ", this::nonNullNorEmptyMessageSupplier) <=> " aaa "


14. requireNonNullNorWhitespaceWithMessageSupplier

requireNonNullNorWhitespace(null, null) <=> java.lang.NullPointerException null
requireNonNullNorWhitespace("", null) <=> java.lang.IllegalArgumentException null
requireNonNullNorWhitespace("   ", null) <=> java.lang.IllegalArgumentException null
requireNonNullNorWhitespace(" aaa ", null) <=> "aaa"

requireNonNullNorWhitespace(null, this::nonNullNorWhitespaceMessageSupplier) <=> java.lang.NullPointerException Supplier: Null or whitespace not allowed
requireNonNullNorWhitespace("", this::nonNullNorWhitespaceMessageSupplier) <=> java.lang.IllegalArgumentException Supplier: Null or whitespace not allowed
requireNonNullNorWhitespace("   ", this::nonNullNorWhitespaceMessageSupplier) <=> java.lang.IllegalArgumentException Supplier: Null or whitespace not allowed
requireNonNullNorWhitespace(" aaa ", this::nonNullNorWhitespaceMessageSupplier) <=> "aaa"


15. requireNonNullNorEmptyElse

requireNonNullNorEmptyElse(null, null) <=> java.lang.NullPointerException defaultStr
requireNonNullNorEmptyElse("", null) <=> java.lang.NullPointerException defaultStr
requireNonNullNorEmptyElse("   ", null) <=> "   "
requireNonNullNorEmptyElse(" aaa ", null) <=> " aaa "

requireNonNullNorEmptyElse(null, ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorEmptyElse("", ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorEmptyElse("   ", ) <=> "   "
requireNonNullNorEmptyElse(" aaa ", ) <=> " aaa "

requireNonNullNorEmptyElse(null,    ) <=> "   "
requireNonNullNorEmptyElse("",    ) <=> "   "
requireNonNullNorEmptyElse("   ",    ) <=> "   "
requireNonNullNorEmptyElse(" aaa ",    ) <=> " aaa "

requireNonNullNorEmptyElse(null,  defaultValue ) <=> " defaultValue "
requireNonNullNorEmptyElse("",  defaultValue ) <=> " defaultValue "
requireNonNullNorEmptyElse("   ",  defaultValue ) <=> "   "
requireNonNullNorEmptyElse(" aaa ",  defaultValue ) <=> " aaa "


16. requireNonNullNorWhitespaceElse

requireNonNullNorWhitespaceElse(null, null) <=> java.lang.NullPointerException defaultStr
requireNonNullNorWhitespaceElse("", null) <=> java.lang.NullPointerException defaultStr
requireNonNullNorWhitespaceElse("   ", null) <=> java.lang.NullPointerException defaultStr
requireNonNullNorWhitespaceElse(" aaa ", null) <=> "aaa"

requireNonNullNorWhitespaceElse(null, ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorWhitespaceElse("", ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorWhitespaceElse("   ", ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorWhitespaceElse(" aaa ", ) <=> "aaa"

requireNonNullNorWhitespaceElse(null,    ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorWhitespaceElse("",    ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorWhitespaceElse("   ",    ) <=> java.lang.IllegalArgumentException defaultStr
requireNonNullNorWhitespaceElse(" aaa ",    ) <=> "aaa"

requireNonNullNorWhitespaceElse(null,  defaultValue ) <=> "defaultValue"
requireNonNullNorWhitespaceElse("",  defaultValue ) <=> "defaultValue"
requireNonNullNorWhitespaceElse("   ",  defaultValue ) <=> "defaultValue"
requireNonNullNorWhitespaceElse(" aaa ",  defaultValue ) <=> "aaa"


17. requireNonNullNorEmptyElseGet

requireNonNullNorEmptyElseGet(null, null) <=> java.lang.NullPointerException supplier
requireNonNullNorEmptyElseGet("", null) <=> java.lang.NullPointerException supplier
requireNonNullNorEmptyElseGet("   ", null) <=> "   "
requireNonNullNorEmptyElseGet(" aaa ", null) <=> " aaa "

requireNonNullNorEmptyElseGet(null, this::defaultValueNullSupplier) <=> java.lang.NullPointerException supplier.get()
requireNonNullNorEmptyElseGet("", this::defaultValueNullSupplier) <=> java.lang.NullPointerException supplier.get()
requireNonNullNorEmptyElseGet("   ", this::defaultValueNullSupplier) <=> "   "
requireNonNullNorEmptyElseGet(" aaa ", this::defaultValueNullSupplier) <=> " aaa "

requireNonNullNorEmptyElseGet(null, this::defaultValueEmptySupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorEmptyElseGet("", this::defaultValueEmptySupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorEmptyElseGet("   ", this::defaultValueEmptySupplier) <=> "   "
requireNonNullNorEmptyElseGet(" aaa ", this::defaultValueEmptySupplier) <=> " aaa "

requireNonNullNorEmptyElseGet(null, this::defaultValueWhitespaceSupplier) <=> "   "
requireNonNullNorEmptyElseGet("", this::defaultValueWhitespaceSupplier) <=> "   "
requireNonNullNorEmptyElseGet("   ", this::defaultValueWhitespaceSupplier) <=> "   "
requireNonNullNorEmptyElseGet(" aaa ", this::defaultValueWhitespaceSupplier) <=> " aaa "

requireNonNullNorEmptyElseGet(null, this::defaultValueSupplier) <=> " Supplier: defaultValue "
requireNonNullNorEmptyElseGet("", this::defaultValueSupplier) <=> " Supplier: defaultValue "
requireNonNullNorEmptyElseGet("   ", this::defaultValueSupplier) <=> "   "
requireNonNullNorEmptyElseGet(" aaa ", this::defaultValueSupplier) <=> " aaa "


18. requireNonNullNorWhitespaceElseGet

requireNonNullNorWhitespaceElseGet(null, null) <=> java.lang.NullPointerException supplier
requireNonNullNorWhitespaceElseGet("", null) <=> java.lang.NullPointerException supplier
requireNonNullNorWhitespaceElseGet("   ", null) <=> java.lang.NullPointerException supplier
requireNonNullNorWhitespaceElseGet(" aaa ", null) <=> "aaa"

requireNonNullNorWhitespaceElseGet(null, this::defaultValueNullSupplier) <=> java.lang.NullPointerException supplier.get()
requireNonNullNorWhitespaceElseGet("", this::defaultValueNullSupplier) <=> java.lang.NullPointerException supplier.get()
requireNonNullNorWhitespaceElseGet("   ", this::defaultValueNullSupplier) <=> java.lang.NullPointerException supplier.get()
requireNonNullNorWhitespaceElseGet(" aaa ", this::defaultValueNullSupplier) <=> "aaa"

requireNonNullNorWhitespaceElseGet(null, this::defaultValueEmptySupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorWhitespaceElseGet("", this::defaultValueEmptySupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorWhitespaceElseGet("   ", this::defaultValueEmptySupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorWhitespaceElseGet(" aaa ", this::defaultValueEmptySupplier) <=> "aaa"

requireNonNullNorWhitespaceElseGet(null, this::defaultValueWhitespaceSupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorWhitespaceElseGet("", this::defaultValueWhitespaceSupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorWhitespaceElseGet("   ", this::defaultValueWhitespaceSupplier) <=> java.lang.IllegalArgumentException supplier.get()
requireNonNullNorWhitespaceElseGet(" aaa ", this::defaultValueWhitespaceSupplier) <=> "aaa"

requireNonNullNorWhitespaceElseGet(null, this::defaultValueSupplier) <=> "Supplier: defaultValue"
requireNonNullNorWhitespaceElseGet("", this::defaultValueSupplier) <=> "Supplier: defaultValue"
requireNonNullNorWhitespaceElseGet("   ", this::defaultValueSupplier) <=> "Supplier: defaultValue"
requireNonNullNorWhitespaceElseGet(" aaa ", this::defaultValueSupplier) <=> "aaa"

