class Subject:
    def __init__(self):
        self._observers = []
        self._state = None

    def attach(self, observer):
        if observer not in self._observers:
            self._observers.append(observer)

    def detach(self, observer):
        if observer in self._observers:
            self._observers.remove(observer)

    def notify(self):
        for observer in self._observers:
            observer.update(self._state)

    def set_state(self, state):
        self._state = state
        self.notify()

class Observer:
    def update(self, state):
        raise NotImplementedError("Subclass must implement update method")

class ConcreteObserver(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, state):
        print(f"{self.name} received state: {state}")

# Usage example:
subject = Subject()
observer1 = ConcreteObserver("Observer1")
observer2 = ConcreteObserver("Observer2")

subject.attach(observer1)
subject.attach(observer2)

subject.set_state("State 1")
subject.set_state("State 2")
