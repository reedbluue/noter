import {StompSessionProvider} from "react-stomp-hooks";
import {PropsWithChildren} from "react";

export const StompProvider = ({children}: PropsWithChildren) => {
  return (
      <StompSessionProvider url={"http://localhost:8081/ws"}>
        {children}
      </StompSessionProvider>
  );
}