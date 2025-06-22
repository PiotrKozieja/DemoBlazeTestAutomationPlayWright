📖 Overview
This project is a comprehensive test automation framework built with Microsoft Playwright and TestNG for Java. The framework implements the Page Object Model (POM) design pattern to provide maintainable, scalable, and reusable test automation for web applications.
The framework is designed to test the Demoblaze e-commerce demo website, covering all major user workflows including product browsing, cart management, user authentication, and order processing.

📋 Test Coverage
The framework covers essential e-commerce functionality:
- Homepage: Loading, navigation, category filtering
- Shopping: Product selection, cart management, order placement
- User Auth: Registration, login/logout, form validation
- Contact: Form submission and alert handling

🛠️ Technology Stack
| Technology | Purpose | Version |
|------------|---------|---------|
| **Java** | Programming Language | 11+ |
| **Playwright** | Browser Automation | Latest |
| **TestNG** | Testing Framework | Latest |
| **Maven** | Build Tool | Latest |

📁 Project Structure
src/
├── main/java/
│   ├── Base/
│   │   └── BaseTest.java           # Base test configuration
│   └── Pages/
│       ├── HomePage.java           # Main page navigation
│       ├── LoginPage.java          # User authentication
│       ├── SignupPage.java         # User registration
│       ├── ProductPage.java        # Product details and actions
│       ├── CartPage.java           # Shopping cart operations
│       ├── ContactPage.java        # Contact form handling
│       └── CategoryPages.java      # Product category navigation
└── test/java/
    ├── Cart/
    │   └── CartPageTest.java       # Shopping cart tests
    ├── Contact/
    │   └── ContactTest.java        # Contact form tests
    ├── HomePage/
    │   ├── LoadPageTest.java       # Page loading tests
    │   └── LogoutTest.java         # Logout functionality tests
    └── ProductPage/
        ├── AppleMonitor24ProductPageTest.java
        └── MacBookAirProductPageTest.java
