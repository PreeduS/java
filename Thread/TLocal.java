

public class TLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>(){
        @Override
        protected String initialValue(){                        // called once for each thread
            double rand = Math.random(); 
            return "initialValue: " + rand;
        }
        @Override
        public String get(){                                    // 1st call =  initialValue
            return super.get();                                 // subsequent calls will return the same initial values
        }
    };

    public static ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(() -> {
        double rand = Math.random(); 
        return "initialValue lambda: " + rand + ", name: " + Thread.currentThread().getName();
    });
}


/*
public class LogContext {
    public static ThreadLocal<LogObject> holder = new ThreadLocal<>();
}

// LogContext.holder.set(logData)
// LogContext.holder.get()
// LogContext.holder.remove()               // cleanup

*/