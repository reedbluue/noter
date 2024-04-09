import {StompSessionProvider} from "react-stomp-hooks";
import {PropsWithChildren} from "react";
import {VITE_BASE_URL} from "../configs/Env.ts";

export const StompProvider = ({children}: PropsWithChildren) => {
  return (
      <StompSessionProvider url={`${VITE_BASE_URL}/ws`}>
        {children}
      </StompSessionProvider>
  );
}