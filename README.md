=== Smart Alternative Writing Systems Generator ===

DESCRIPTION:
A Java application that converts text to alternative writing systems
using three design patterns: Prototype, Proxy, and Strategy.

REQUIREMENTS:
- Java JDK 8 or higher
- NetBeans IDE (recommended) or any Java IDE

HOW TO RUN:
1. Open the project in NetBeans
2. Click "Run" or press Shift+F6
3. Login dialog will appear:
   - Enter your name
   - Select your role (Student/Researcher)
   - Press OK to continue or Cancel to exit

USER ROLES:
- Student: Can use Morse Code and Braille only
- Researcher: Can use all systems including Secret Cipher

FEATURES:
- Convert text to Morse Code, Braille, or Secret Cipher
- Decode encoded text back to original
- Two display modes: Compact and Verbose
- Role-based access control
- User-friendly GUI with logout option

DESIGN PATTERNS USED:
1. Prototype Pattern: Encoder objects are cloned instead of created
2. Proxy Pattern: Controls access to Secret Cipher based on user role
3. Strategy Pattern: Dynamic switching between display modes

PROJECT STRUCTURE:
- MainGUI.java: Main application window
- User.java: User information and role
- EncoderPrototype.java: Base class for all encoders
- MorseEncoder.java, BrailleEncoder.java, SecretEncoder.java: Specific encoders
- EncoderProxy.java: Access control proxy
- DisplayStrategy.java, CompactStrategy.java, VerboseStrategy.java: Display strategies

NOTES:
- Press Cancel during login to exit the application
- Use Logout button to exit gracefully
- Students cannot access Secret Cipher system

DEVELOPED BY: [Bilal Abeed & Abdullah Altryky & Mohammed Omar]
COURSE: Software Design Patterns
DATE: December 2025
