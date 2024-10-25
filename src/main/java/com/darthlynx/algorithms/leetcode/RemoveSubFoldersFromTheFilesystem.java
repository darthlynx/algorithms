package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
public class RemoveSubFoldersFromTheFilesystem {

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    public List<String> removeSubfolders(String[] folder) {
        
        // Sort in alphabetical order
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            // check the last folder in the result list
            // because of sorting, root folder will go before the subfolders
            // therefore if current folder starts with the last folder name
            // it means it is a subfolder
            String lastFolder = result.get(result.size()-1) + "/";

            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i]);
            }
        }

        return result;
    }
}
