class CmmUtil():
    def nvl2(pStr, chgStr):
        if pStr is None:
            return chgStr
        else:
            return pStr

    def nvl(pStr):
        return CmmUtil.nvl2(pStr, "")