# Discrete Event Queue Simulator

A Java-based discrete event simulation system that models customer arrivals, service queues, and server behavior with random event generation.

## 📋 Overview

This project implements a discrete event simulator for modeling queue systems, such as bank tellers, customer service centers, or any scenario where entities arrive, wait in queues, and are served by limited resources. The simulator uses priority queues and event-driven architecture to accurately model real-world queueing systems.

## ✨ Features

- **Event-Driven Architecture**: Uses priority queue to process events in chronological order
- **Multiple Servers**: Supports configurable number of servers with individual queues
- **Random Event Generation**: Implements exponential distributions for realistic arrival and service times
- **Server States**: Models servers as busy, available, or resting
- **Queue Management**: Configurable queue lengths for each server
- **Statistics Tracking**: Monitors customers served, waiting times, and departures

## 🏗️ Architecture

### Core Components

- **Event**: Abstract base class for all simulation events
- **EventSimulator**: Main simulation engine that manages the event loop
- **EventComparator**: Ensures events are processed in time order
- **Server**: Represents a service point with queue capacity
- **Customer**: Entity being served in the simulation
- **RandomGenerator**: Generates random values for stochastic events

### Event Types

1. **ArrivalEvent**: Customer arrives at the system
2. **ServedEvent**: Customer begins service
3. **WaitEvent**: Customer joins a queue
4. **DoneEvent**: Service completion
5. **LeaveEvent**: Customer departs without service
6. **ServerRest**: Server takes a break
7. **ServerBack**: Server returns from break

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Ant (for building with build.xml)

### Building the Project

```bash
# Using Ant
ant compile

# Or compile manually
javac -d build/classes src/simulator/*.java
```

### Running the Simulator

```bash
# Using Ant
ant run

# Or run directly
java -cp build/classes simulator.Simulator
```

### Input Parameters

When running the simulator, you'll be prompted for:

1. **Seed Value**: For random number generation (ensures reproducibility)
2. **Number of Servers**: How many service points exist
3. **Queue Length**: Maximum customers that can wait per server
4. **Number of Customers**: Total customers to simulate
5. **Arrival Rate**: Lambda parameter for arrival time distribution
6. **Service Rate**: Lambda parameter for service time distribution
7. **Resting Rate**: Lambda parameter for server break times

### Example Usage

```
Enter the seed Value
42
Enter number of servers
3
Enter number of queue length
5
Enter number of Customer
20
Enter number of arrival rate
0.5
Enter number of service rate
1.0
Enter number of Resting rate
0.1
```

## 📊 Output

The simulator outputs a chronological log of all events including:
- Customer arrivals
- Service starts and completions
- Queue joins and departures
- Server rest periods
- Summary statistics

## 🛠️ Project Structure

```
simulator/
├── src/
│   └── simulator/
│       ├── Simulator.java          # Main entry point
│       ├── EventSimulator.java     # Core simulation engine
│       ├── Event.java               # Base event class
│       ├── ArrivalEvent.java        # Customer arrival events
│       ├── ServedEvent.java         # Service start events
│       ├── WaitEvent.java           # Queue entry events
│       ├── DoneEvent.java           # Service completion events
│       ├── LeaveEvent.java          # Customer departure events
│       ├── ServerRest.java          # Server break events
│       ├── ServerBack.java          # Server return events
│       ├── Server.java              # Server entity
│       ├── Customer.java            # Customer entity
│       ├── EventComparator.java     # Event ordering
│       ├── RandomGenerator.java     # Random value generation
│       └── Sequence.java            # Sequential ID generation
├── build.xml                        # Ant build configuration
└── README.md                        # This file
```

## 🎓 Learning Outcomes

This project demonstrates:
- Object-oriented design principles (inheritance, polymorphism)
- Event-driven programming patterns
- Priority queue data structures
- Discrete event simulation techniques
- Random process modeling
- Java collections framework

## 🔮 Future Enhancements

- [ ] Add GUI visualization of the simulation
- [ ] Export statistics to CSV/JSON
- [ ] Implement priority customers
- [ ] Add multiple queue disciplines (FIFO, LIFO, Priority)
- [ ] Real-time animation of events
- [ ] Configuration file support (YAML/JSON)
- [ ] Unit tests for event handling
- [ ] Performance metrics and analytics dashboard

## 📝 License

This project is available under the MIT License. See LICENSE file for details.

## 👤 Author

**Your Name**
- GitHub: [@hinaamin375](https://github.com/hinaamin375)


