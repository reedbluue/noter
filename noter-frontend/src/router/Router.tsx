import {createBrowserRouter} from "react-router-dom";
import {Base} from "../layout/Base";
import {DocumentPage} from "../pages/DocumentPage.tsx";
import {StompProvider} from "../components/StompProvider.tsx";
import {IndexPage} from "../pages/IndexPage.tsx";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Base.Page/>,
    children: [
      {
        index: true,
        element: <IndexPage/>
      },
      {
        path: "/:documentId/*",
        element: <StompProvider><DocumentPage/></StompProvider>
      }
    ],
  }
]);