# Macy's Price Tracker

A Java-based web scraping application that monitors Macy's product prices and sends email notifications when items drop below your target price. Never miss a deal again!

## Features

- **Web Scraping**: Uses JSoup to fetch real-time prices from Macy's website
- **Price Monitoring**: Compares current prices with user-defined target prices
- **Email Notifications**: Automatically sends emails when prices drop below target
- **JavaFX GUI**: User-friendly interface for managing tracked items
- **Persistent Storage**: our tracked items are saved between sessions using Java serialization
- **Bulk Email Setup**: Option to use the same email for multiple items

## Screenshots

### Main Interface - Add Items
<img src="https://github.com/peroute/retail-price-tracker/blob/master/img/readme/screen1.png" alt="Add Items Screen" width="300">
**Add Macy's product URLs with target prices and email addresses**

### Item List Management
<img src="https://github.com/peroute/retail-price-tracker/blob/master/img/readme/screen2.png" alt="Add Items Screen" width="300">
*View and manage your tracked items with current prices and targets*

## Tech Stack

- **Java** - Core application language
- **JavaFX** - User interface framework
- **JSoup** - Web scraping library
- **Jakarta Mail** - Email notification service
- **Java Serialization** - Data persistence for tracked items

## Known Issues & Solutions

### Web Scraping Restrictions

**Problem**: Macy's website recently implemented stricter anti-bot measures, returning HTTP 403 errors when attempting to scrape with JSoup.

**Solution**: A Selenium-based solution has been developed to bypass these restrictions:

- **Branch**: `scrapping-with-selenium`
- **Technology**: Selenium WebDriver with Chrome driver
- **Advantage**: Mimics real browser behavior to avoid detection
- **Usage**: Switch to the selenium branch for uninterrupted scraping functionality

This alternative approach uses automated browser control to fetch price data, effectively circumventing the 403 error restrictions.

**Happy deal hunting! 🛍️**
