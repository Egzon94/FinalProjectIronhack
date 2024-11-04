# Trading Application

## Description of the Project

This project is a Spring Boot-based trading application that allows users to manage financial portfolios, conduct trades, and log each transaction in a structured and traceable way. The application is built around three main classes—Trade, Portfolio, and Transactions—each representing different aspects of the trading process. Through this setup, users can manage their stock holdings, associate trades with specific portfolios, and record transactional details for all activities.


## Key Features:

+ Trade Management: Users can create trades associated with specific portfolios and users, tracking stock symbols, 
  quantities, and prices.
+ Portfolio Organization: Organize trades into portfolios, each with a unique name, user association, and a list of 
  trades.
+ Transaction Logging: Log each transaction with details like amount and type (buy/sell), linked to both the trade 
  and portfolio.




|    TradeClass     |                                                             
|-------------------|
|  - id             |
|  - stockSymbol    |
|  - quantity       |
|  - price          |
|  - user           |
|  - portfolio      |
|  - transactions   |


|   PortfolioClass   |
|--------------------|
|  - id             |
|  - name           |
|  - trades         |
|  - user           |
|  - transactions    |

|  TransactionsClass    |
|-----------------------|
|  - id                 |
|  - transactionType    |
|  - amount             |
|  - trade              |
|  - portfolio          |


## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Egzon94/FinalProjectIronhack.git
   ```

2. **Configure Database:**
   ```bash
    CREATE DATABASE trading_smart_db;
   ```

   
3. **Set up database connection in application.properties:**
   ```bash
spring.application.name=TradingNotes
spring.datasource.url=jdbc:mysql://localhost:3306/trading_smart_db
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.username=root
spring.datasource.password=Ei28021994@
server.port=6060
   ```

4. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

5. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

6. **Access the application:**
   Open a web browser and go to `http://localhost:6060` to view the application.




## Controllers and Routes Structure
+ PortfolioController:
   /api/portfolio
GET /: Retrieves all portfolio items.
POST /: Adds a new portfolio item.


+ TradeController:
   /api/trade
GET /: Retrieves all trades.
POST /: Executes a new trade.

+ TransactionsController:
   /api/transactions
GET /: Retrieves all transactions.
POST /: Records a new transaction.





+ Trade: Stores trade details like stockSymbol, quantity, price, and relationships with User and Portfolio.
  
+ Portfolio: Manages a collection of trades and transactions, with fields for name, trades, and associated user.
  
+ Transactions: Records each trade-related activity, with fields like transactionType and amount, and relationships 
  to both Trade and Portfolio.
