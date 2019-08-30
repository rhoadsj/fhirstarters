## IntelliJ IDE how-to

You can easily **select multiple fragments** of text. To do that, it's enough to keep Alt+Shift and drag your mouse cursor.

To select **multiple words**, press Alt+Shift, place the caret at each word to be selected and double-click the left mouse button.

**Quick-doc** F1

You can quickly navigate in the currently edited file with **⌘F12 (Navigate | File Structure)**.

SmartType code completion **⌃⇧Space**


The SmartType code completion may be used after the new keyword, to instantiate an object of the expected type.

To quickly select the **currently edited element** (class, file, method or field) in any view (Project view, Structure view or other), press** ⌥F1**.

When you want to **catch exceptions thrown by some code fragment**, select it in the editor, press **⌥⌘T (Code | Surround With)** and choose try / catch. The catch blocks for all the exceptions thrown inside the block will be generated automatically.

**⌥↑** (extend selection) in the editor selects the word at the caret and then selects expanding areas of the source code

You can comment or uncomment lines and blocks of code using **⌘/** and ⌥⌘/.
⌘/ comments or uncomments the current line or selected block with single line comments (//...).
⌥⌘/ encloses the selected block in a block comment (/*...*/).
To uncomment a commented block press ⌥⌘/ anywhere inside it.

To open your browser with documentation for the element at the editor's caret, press ⇧F1 (View | External Documentation).

When you need to cast an expression value to the required type the SmartType code completion will help you. For example, type
String s = (<caret is here> 
and press ⌃⇧Space to see what happens.

⌘E (View | Recent Files) brings a popup list of the recently visited files. Choose the desired file and press Enter to open it.

⌘E (View | Recent Files) brings a popup list of the recently visited files. Choose the desired file and press Enter to open it.

To see the inheritance hierarchy for a selected class, press ⌃H (Navigate | Type Hierarchy). You can also invoke the hierarchy view right from the editor to see the hierarchy for the currently edited class.

To easily evaluate the value of any expression while debugging the program, select its text in the editor (you may press a ⌥↑ a few times to efficiently perform this operation) and press ⌥F8.

The shortcuts such as F1 (View | Quick Documentation), ⌘P (View | Parameter Info), ⌘B (Navigate | Declaration) and others can be used not only in the editor but in the code completion popup list as well.

toggle between show editor only and show all shift-cmd-F12

Terminal opt-F12

Find in current window cmd-F  next occurrence cmd-G
prev occurrence shift-cmd-G

surround with opt-cmd-T

expand or shrink selection syntactically cmd-up cmd-down

completion cmd-space more cmd-space twice

cmd shift space Smart Completion

shift-cmd-return Statement Completion (insert e.g. misssing punctuation)

recent file cmd-E

show strcture window cmd-F12





