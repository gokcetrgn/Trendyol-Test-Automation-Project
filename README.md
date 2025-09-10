# 🛒 Trendyol Test Automation (Selenium + Gauge)

This repository contains **end-to-end test automation scenarios** for **Trendyol**, developed with **Selenium WebDriver** and **Gauge**.  
The test cases are based on the specifications written in `trendyol_testcases.xlsx` and aim to validate the **core shopping experience** of Trendyol.  

---

## 🚀 Covered Scenarios
Key test scenarios automated for Trendyol include:

## 📌 Project Overview
The goal of this project is to validate critical user flows on **Trendyol** such as:
- Homepage navigation  
- User registration & login  
- Logout  
- Product search  
- Filtering (brand, price range)  

The test cases are implemented in **Gauge** with step definitions in **Java + Selenium**.

| Test Case ID | Page            | Description                       | Status                   |
| ------------ | --------------- | --------------------------------- | ------------------------ |
| TC1          | Homepage        | Navigate to Trendyol homepage     | ✅ Passed                 |
| TC2          | Sign Up         | Navigate to Sign Up page          | ✅ Passed                 |
| TC3          | Sign Up         | Register a new user               | ❌ Failed (Captcha issue) |
| TC4          | Header          | Logout functionality              | ✅ Passed                 |
| TC5          | Login           | User login with valid credentials | ✅ Passed                 |
| TC6          | Search          | Product search                    | ✅ Passed                 |
| TC7          | Search          | Search via popular searches       | ✅ Passed                 |
| TC8          | Product Listing | Filter by brand                   | ✅ Passed                 |
| TC9          | Product Listing | Select predefined price range     | ✅ Passed                 |
| TC10         | Product Listing | Enter custom price range          | ✅ Passed                 |


---


- **Homepage**
  - Verify that the homepage loads successfully  
  - Validate visibility of banners, categories, and login/register buttons  

- **Search**
  - Search for a product by keyword  
  - Validate search results are relevant  
  - Apply category/brand filters  

- **Product Details**
  - Navigate to product detail page  
  - Verify price, description, and stock information  
  - Check photo gallery and user reviews  

- **Shopping Cart**
  - Add product(s) to cart  
  - Increase/decrease product quantity  
  - Remove product from cart  
  - Validate total price update  

- **Login / Registration**
  - Successful login with valid credentials  
  - Error handling for wrong email/password  
  - New user registration flow  

- **Checkout**
  - Proceed to checkout with items in cart  
  - Validate address and payment options  

---

## 🛠 Tech Stack
- **Selenium WebDriver** → Web automation  
- **Gauge** → Test runner & reporting  
- **Java** → Programming language  
- **Maven** → Dependency management  
- **JUnit/TestNG** → Execution framework  

---
## Example Scenario

## Trendyol - Add Product to Cart

#### Scenario: Add product to cart from search
* Go to Trendyol homepage
* Accept cookies if prompted
* Search for "Nike Shoes"
* Select the first product from results
* Add product to the shopping cart
* Verify product is successfully added to the cart

---

# 🎯 Purpose

The purpose of this project is to:

Automate real-world e-commerce flows on Trendyol

Practice Selenium + Gauge test automation

Ensure test cases from trendyol_testcases.xlsx are executed automatically

Build a scalable, maintainable automation framework

---

## ▶️ How to Run
1. Clone the repository:  
   ```bash
   git clone https://github.com/username/trendyol-automation.git


---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites
- Install **Java 11+**
- Install **Maven**
- Install **Gauge**
  ```bash
  choco install gauge   # Windows (Chocolatey)
  brew install gauge    # macOS
  
## Install Gauge plugins:
gauge install java
gauge install html-report

## 📜 License

This project is created for educational and testing purposes.



