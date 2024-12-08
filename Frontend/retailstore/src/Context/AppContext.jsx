import React, { createContext, useState } from "react";

export const AppContext = createContext();

const AppProvider = ({ children }) => {
  const [cart, setCart] = useState([]);
  const [user, setUser] = useState({});

  return (
    <AppContext.Provider value={{ cart, setCart, user, setUser }}>
      {children}
    </AppContext.Provider>
  );
};

export default AppProvider;
