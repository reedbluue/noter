import "./init.js";
import {createBrowserRouter} from "react-router-dom";
import {Base} from "../layout/Base";
import {DocumentPage} from "../pages/DocumentPage.tsx";
import {StompSessionProvider} from "react-stomp-hooks";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Base.Page/>,
    children: [
      {
        index: true,
        element: <p>Main</p>
      },
      {
        path: "/:documentId",
        element: <StompSessionProvider
            url={"http://localhost:8081/ws"}>
          <DocumentPage/>
        </StompSessionProvider>
      }
    ],
  }
]);