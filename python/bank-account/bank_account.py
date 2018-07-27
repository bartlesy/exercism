from functools import wraps
from threading import Lock


class BankAccount(object):

    def __init__(self):
        self.balance = None
        self.lock = Lock()

    def _check_open(f):
        @wraps(f)
        def wrapped(inst, *args, **kwargs):
            if inst.balance is None:
                raise ValueError("Account is closed")
            return f(inst, *args, **kwargs)
        return wrapped

    @_check_open
    def get_balance(self):
        return self.balance

    def open(self):
        # what should opening an open account do?
        # I'll make it a nop
        if self.balance is not None:
            return
        self.balance = 0
        return

    @_check_open
    def deposit(self, amount):
        if amount < 0:
            raise ValueError("Deposit amount must be non-negative")
        with self.lock:
            self.balance += amount
        return

    @_check_open
    def withdraw(self, amount):
        if amount < 0:
            raise ValueError("Withdrawal amount must be non-negative")
        if amount > self.balance:
            raise ValueError("Can't withdraw more than available balance")
        with self.lock:
            self.balance = self.balance - amount
        return

    @_check_open
    def close(self):
        # should closing require balance be zero?
        self.balance = None
        return
